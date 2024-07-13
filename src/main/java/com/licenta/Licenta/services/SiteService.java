package com.licenta.Licenta.services;

import com.licenta.Licenta.dtos.DetailsDto;
import com.licenta.Licenta.dtos.UserDto;
import com.licenta.Licenta.dtos.ViewInfrastructureDto;
import com.licenta.Licenta.dtos.ViewOfferDto;
import com.licenta.Licenta.entities.*;
import com.licenta.Licenta.repositories.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SiteService {
    private final InfrastructureRepository infrastructureRepository;
    private final UserRepository userRepository;
    private final OfferRepository offerRepository;
    private final InfrastructuresImagesRepository infrastructuresImagesRepository;

    private final OffersImagesRepository offersImagesRepository;

    public SiteService(InfrastructureRepository infrastructureRepository, UserRepository userRepository, OfferRepository offerRepository, InfrastructuresImagesRepository infrastructuresImagesRepository, OffersImagesRepository offersImagesRepository) {
        this.infrastructureRepository = infrastructureRepository;
        this.userRepository = userRepository;
        this.offerRepository = offerRepository;
        this.infrastructuresImagesRepository = infrastructuresImagesRepository;
        this.offersImagesRepository = offersImagesRepository;
    }

    public DetailsDto getDetails(){
        String infrastructures_count = String.valueOf(infrastructureRepository.countByPrivate_status());
        String offers_count = String.valueOf(offerRepository.countByPrivate_status());

        return DetailsDto.builder()
                .infrastructures_count(infrastructures_count)
                .offers_count(offers_count)
                .build();
    }

    public UserDto getViewUserOwner(Integer user_id){
        Optional<User> optionalUser = userRepository.findById(user_id);

        return UserDto.builder()
                .user_email(optionalUser.get().getEmail())
                .user_name(optionalUser.get().getUser_name())
                .user_image(optionalUser.get().getImage())
                .user_id(optionalUser.get().getUser_id())
                .build();
    }

    public DetailsDto getViewUserOwnerDetails(Integer userId){
        List<Infrastructure> infrastructures = infrastructureRepository.findByUser_idDetails(userId);
        List<Offer> offers = offerRepository.findByUser_idDetails(userId);
        String infrCount = String.valueOf(infrastructures.stream().count());
        String offerCount = String.valueOf(offers.stream().count());

        return DetailsDto.builder()
                .infrastructures_count(infrCount)
                .offers_count(offerCount)
                .build();
    }

    public List<ViewInfrastructureDto> getOwnerInfrastructures(Integer id){

        return infrastructureRepository.findByUser_idOwner(id)
                .stream()
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
                            .build();
                })
                .collect(Collectors.toList());
    }

    public List<ViewOfferDto> getOwnerOffers(Integer id){
        return offerRepository.findByUser_idOwner(id)
                .stream()
                .filter(o -> o.isPrivate_status())
                .map(o -> {
                    byte[] imageData = new byte[0];
                    try {
                        imageData = offersImagesRepository.findByOfferId(o.getOffer_id())
                                .map(OffersImages::getData)
                                .orElse(new byte[0]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    int maxLength = 100;
                    String description = o.getOffer_description();
                    if (description.length() > maxLength) {
                        description = description.substring(0, maxLength) + "...";
                    }
                    return ViewOfferDto.builder()
                            .offer_name(o.getOffer_name())
                            .offer_description(description)
                            .offer_phone(o.getOffer_phone())
                            .offer_image(imageData)
                            .offer_id(o.getOffer_id())
                            .build();
                })
                .collect(Collectors.toList());
    }

}
