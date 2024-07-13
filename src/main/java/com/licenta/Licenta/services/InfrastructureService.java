package com.licenta.Licenta.services;

import com.licenta.Licenta.dtos.InfrastructureDto;
import com.licenta.Licenta.dtos.InfrastructurePageDto;
import com.licenta.Licenta.dtos.ViewInfrastructureDto;
import com.licenta.Licenta.entities.Infrastructure;
import com.licenta.Licenta.entities.InfrastructuresImages;
import com.licenta.Licenta.entities.User;
import com.licenta.Licenta.repositories.InfrastructureRepository;
import com.licenta.Licenta.repositories.InfrastructuresImagesRepository;
import com.licenta.Licenta.repositories.UserRepository;
import java.util.Collections;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class InfrastructureService {
    private final InfrastructureRepository infrastructureRepository;
    private final InfrastructuresImagesRepository infrastructuresImagesRepository;
    private final UserRepository userRepository;
    private final ImagineService imagineService;
    @SneakyThrows
    public void save(InfrastructureDto infrastructureDto, MultipartFile image){

        LocalDate currentDate = LocalDate.now();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = ((Jwt)authentication.getCredentials()).getClaim("email");
        Optional<User> optionalUser = userRepository.findByEmail(userEmail);
        Integer userId = optionalUser.get().getUser_id();

        Infrastructure infrastructure = new Infrastructure();
        InfrastructuresImages infrastructuresImages = new InfrastructuresImages();

        infrastructure.setInfrastructure_name(infrastructureDto.infrastructure_name);
        infrastructure.setInfrastructure_key_words(infrastructureDto.infrastructure_key_words);
        infrastructure.setInfrastructure_description(infrastructureDto.infrastructure_description);
        infrastructure.setUser_id(userId);
        infrastructure.setInfrastructure_email(infrastructureDto.infrastructure_email);
        infrastructure.setInfrastructure_phone(infrastructureDto.infrastructure_phone);
        infrastructure.setInfrastructure_benefits(infrastructureDto.infrastructure_benefits);
        infrastructure.setInfrastructure_access_info(infrastructureDto.infrastructure_access_info);
        infrastructure.setInfrastructure_tehnical_specification(infrastructureDto.infrastructure_tehnical_specification);
        infrastructure.setPrivate_status(infrastructureDto.private_status);
        infrastructure.setInfrastructure_data_publication(currentDate);
        infrastructure.setInfrastructure_lat(infrastructureDto.infrastructure_lat);
        infrastructure.setInfrastructure_lon(infrastructureDto.infrastructure_lon);

        Infrastructure savedInfrastructure = infrastructureRepository.save(infrastructure);

        Integer infrastructureID = savedInfrastructure.getInfrastructure_id();
        infrastructuresImages.setInfrastructure_id(infrastructureID);
        infrastructuresImages.setData(image.getBytes());

        infrastructuresImagesRepository.save(infrastructuresImages);
    }

    public InfrastructurePageDto getViewInfrastructure(Integer infrastructure_id){

        Infrastructure infrastructure = infrastructureRepository.findById(infrastructure_id).orElseThrow(() ->
                new RuntimeException("Nu exista infrastructura cu Id-ul " + infrastructure_id));

        return InfrastructurePageDto.builder()
                .infrastructure_description(infrastructure.getInfrastructure_description())
                .infrastructure_key_words(infrastructure.getInfrastructure_key_words())
                .infrastructure_name(infrastructure.getInfrastructure_name())
                .infrastructure_phone(infrastructure.getInfrastructure_phone())
                .infrastructure_benefits(infrastructure.getInfrastructure_benefits())
                .infrastructure_email(infrastructure.getInfrastructure_email())
                .infrastructure_access_info(infrastructure.getInfrastructure_access_info())
                .infrastructure_tehnical_specification(infrastructure.getInfrastructure_tehnical_specification())
                .infrastructure_image(infrastructuresImagesRepository.findByInfrastructureId(infrastructure_id).get().getData())
                .user_id(infrastructure.getUser_id())
                .user_email(userRepository.findById(infrastructure.getUser_id()).get().getEmail())
                .private_status(infrastructure.isPrivate_status())
                .infrastructure_lon(infrastructure.getInfrastructure_lon())
                .infrastructure_lat(infrastructure.getInfrastructure_lat())
                .build();
    }

    public List<ViewInfrastructureDto> getAllInfrastructures(){

        return infrastructureRepository.findAll()
                .stream()
                .filter(o-> o.isPrivate_status())
                .map(o -> {
                    byte[] imageData = new byte[0];
                    try {
                        imageData = infrastructuresImagesRepository.findByInfrastructureId(o.getInfrastructure_id())
                                .map(InfrastructuresImages::getData)
                                .orElse(new byte[0]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    int maxLength = 100;
                    String description = o.getInfrastructure_description();
                    if (description.length() > maxLength) {
                        description = description.substring(0, maxLength) + "...";
                    }
                    return ViewInfrastructureDto.builder()
                            .infrastructure_name(o.getInfrastructure_name())
                            .infrastructure_description(description)
                            .infrastructure_phone(o.getInfrastructure_phone())
                            .infrastructure_image(imageData)
                            .infrastructure_id(o.getInfrastructure_id())
                            .infrastructure_email(o.getInfrastructure_email())
                            .infrastructure_data_publication(o.getInfrastructure_data_publication())
                            .build();
                })
                .collect(Collectors.toList());
    }

    public List<ViewInfrastructureDto> getMyInfrastructures(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = ((Jwt)authentication.getCredentials()).getClaim("email");
        Optional<User> optionalUser = userRepository.findByEmail(userEmail);
        Integer userId = optionalUser.get().getUser_id();

        return infrastructureRepository.findByUser_id(userId)
                .stream()
                .map(o -> {
                    byte[] imageData = new byte[0];
                    try {
                        imageData = infrastructuresImagesRepository.findByInfrastructureId(o.getInfrastructure_id())
                                .map(InfrastructuresImages::getData)
                                .orElse(new byte[0]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    int maxLength = 100;
                    String description = o.getInfrastructure_description();
                    if (description.length() > maxLength) {
                        description = description.substring(0, maxLength) + "...";
                    }
                    return ViewInfrastructureDto.builder()
                            .infrastructure_name(o.getInfrastructure_name())
                            .infrastructure_description(description)
                            .infrastructure_phone(o.getInfrastructure_phone())
                            .infrastructure_image(imageData)
                            .infrastructure_id(o.getInfrastructure_id())
                            .public_status(o.isPrivate_status())
                            .build();
                })
                .collect(Collectors.toList());
    }

    @SneakyThrows
    public void modify(InfrastructureDto infrastructureDto, MultipartFile image, Integer infrastructureId){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = ((Jwt)authentication.getCredentials()).getClaim("email");
        Optional<User> optionalUser = userRepository.findByEmail(userEmail);
        Integer userId = optionalUser.get().getUser_id();

        Optional<Infrastructure> infrastructure = infrastructureRepository.findById(infrastructureId);

        infrastructure.get().setInfrastructure_name(infrastructureDto.infrastructure_name);
        infrastructure.get().setInfrastructure_key_words(infrastructureDto.infrastructure_key_words);
        infrastructure.get().setInfrastructure_description(infrastructureDto.infrastructure_description);
        infrastructure.get().setUser_id(userId);
        infrastructure.get().setInfrastructure_email(infrastructureDto.infrastructure_email);
        infrastructure.get().setInfrastructure_phone(infrastructureDto.infrastructure_phone);
        infrastructure.get().setInfrastructure_benefits(infrastructureDto.infrastructure_benefits);
        infrastructure.get().setInfrastructure_access_info(infrastructureDto.infrastructure_access_info);
        infrastructure.get().setInfrastructure_tehnical_specification(infrastructureDto.infrastructure_tehnical_specification);
        infrastructure.get().setPrivate_status(infrastructureDto.private_status);
        infrastructure.get().setInfrastructure_lon(infrastructureDto.infrastructure_lon);
        infrastructure.get().setInfrastructure_lat(infrastructureDto.infrastructure_lat);

        Infrastructure savedInfrastructure = infrastructureRepository.save(infrastructure.get());
        if(image != null) {
            Integer infrastructureID = savedInfrastructure.getInfrastructure_id();
            Optional<InfrastructuresImages> infrastructuresImages = infrastructuresImagesRepository.findByInfrastructureId(infrastructureId);
            infrastructuresImages.get().setInfrastructure_id(infrastructureID);
            infrastructuresImages.get().setData(image.getBytes());

            infrastructuresImagesRepository.save(infrastructuresImages.get());
        }
    }
    public void deleteInfrastructureById(Integer infrastructureId){
        Infrastructure infrastructure = infrastructureRepository.findById(infrastructureId)
                .orElseThrow(() -> new RuntimeException("No agency with id " + infrastructureId));

        imagineService.deleteInfrastructureById(infrastructureId);
        infrastructureRepository.delete(infrastructure);

    }

    public List<ViewInfrastructureDto> searchInfrastructures(String name){
        if(!Objects.equals(name, "")) {
            return infrastructureRepository.findAll()
                    .stream()
                    .filter(o -> o.getInfrastructure_name().toLowerCase().contains(name.toLowerCase()) ||
                            o.getInfrastructure_key_words().toLowerCase().contains(name.toLowerCase()) ||
                            userRepository.findById(o.getUser_id()).get().getEmail().contains(name.toLowerCase()))
                    .filter(o -> o.isPrivate_status())
                    .map(o -> {
                        byte[] imageData = new byte[0];
                        try {
                            imageData = infrastructuresImagesRepository.findByInfrastructureId(o.getInfrastructure_id())
                                    .map(InfrastructuresImages::getData)
                                    .orElse(new byte[0]);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        int maxLength = 100;
                        String description = o.getInfrastructure_description();
                        if (description.length() > maxLength) {
                            description = description.substring(0, maxLength) + "...";
                        }
                        return ViewInfrastructureDto.builder()
                                .infrastructure_name(o.getInfrastructure_name())
                                .infrastructure_description(description)
                                .infrastructure_phone(o.getInfrastructure_phone())
                                .infrastructure_image(imageData)
                                .infrastructure_id(o.getInfrastructure_id())
                                .infrastructure_data_publication(o.getInfrastructure_data_publication())
                                .build();
                    })
                    .collect(Collectors.toList());
        }else{
            return getAllInfrastructures();
        }
    }
    public List<ViewInfrastructureDto> getNewInfrastructures(){
        List<ViewInfrastructureDto> newInfrastructures = getAllInfrastructures();

        Collections.reverse(newInfrastructures);
        return newInfrastructures;
    }
}
