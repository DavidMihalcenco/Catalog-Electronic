package com.licenta.Licenta.services;

import com.licenta.Licenta.dtos.*;
import com.licenta.Licenta.entities.*;
import com.licenta.Licenta.repositories.OfferRepository;
import com.licenta.Licenta.repositories.OffersImagesRepository;
import com.licenta.Licenta.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OfferService {
    private final UserRepository userRepository;
    private final OfferRepository offerRepository;
    private final OffersImagesRepository offersImagesRepository;
    private final ImagineService imagineService;

    @SneakyThrows
    public void saveOffer(OfferDto offerDto, MultipartFile image){
        LocalDate currentDate = LocalDate.now();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = ((Jwt)authentication.getCredentials()).getClaim("email");
        Optional<User> optionalUser = userRepository.findByEmail(userEmail);
        Integer userId = optionalUser.get().getUser_id();

        Offer offer = new Offer();
        OffersImages offersImages = new OffersImages();

        offer.setOffer_name(offerDto.offer_name);
        offer.setOffer_key_words(offerDto.offer_key_words);
        offer.setOffer_benefits(offerDto.offer_benefits);
        offer.setOffer_colaboration(offerDto.offer_colaborations);
        offer.setOffer_email(offerDto.offer_email);
        offer.setOffer_description(offerDto.offer_description);
        offer.setOffer_phone(offerDto.offer_phone);
        offer.setOffer_context(offerDto.offer_context);
        offer.setUser_id(userId);
        offer.setOffer_utilization(offerDto.offer_utilization);
        offer.setOffer_status(offerDto.offer_status);
        offer.setPrivate_status(offerDto.private_status);
        offer.setOffer_data_publication(currentDate);

        Offer savedOffer = offerRepository.save(offer);

        Integer offerID = savedOffer.getOffer_id();
        offersImages.setOffer_id(offerID);
        offersImages.setData(image.getBytes());

        offersImagesRepository.save(offersImages);
    }

    public List<ViewOfferDto> getAllOffers(){

        return offerRepository.findAll()
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
                    return ViewOfferDto.builder()
                            .offer_name(o.getOffer_name())
                            .offer_phone(o.getOffer_phone())
                            .offer_description(o.getOffer_description())
                            .offer_image(imageData)
                            .offer_id(o.getOffer_id())
                            .offer_email(o.getOffer_email())
                            .offer_data_publication(o.getOffer_data_publication())
                            .build();
                })
                .collect(Collectors.toList());
    }

    public OfferPageDto getViewOffer(Integer offer_id){

        Offer offer = offerRepository.findById(offer_id).orElseThrow(() ->
                new RuntimeException("Nu exista infrastructura cu Id-ul " + offer_id));

        return OfferPageDto.builder()
                .offer_description(offer.getOffer_description())
                .offer_key_words(offer.getOffer_key_words())
                .offer_name(offer.getOffer_name())
                .offer_phone(offer.getOffer_phone())
                .offer_benefits(offer.getOffer_benefits())
                .offer_email(offer.getOffer_email())
                .offer_colaborations(offer.getOffer_colaboration())
                .offer_context(offer.getOffer_context())
                .offer_status(offer.getOffer_status())
                .offer_utilization(offer.getOffer_utilization())
                .offer_image(offersImagesRepository.findByOfferId(offer_id).get().getData())
                .private_status(offer.isPrivate_status())
                .user_id(offer.getUser_id())
                .user_email(userRepository.findById(offer.getUser_id()).get().getEmail())
                .build();
    }

    public List<ViewOfferDto> getMyOffers(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = ((Jwt)authentication.getCredentials()).getClaim("email");
        Optional<User> optionalUser = userRepository.findByEmail(userEmail);
        Integer userId = optionalUser.get().getUser_id();

        return offerRepository.findByUser_id(userId)
                .stream()
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
                            .public_status(o.isPrivate_status())
                            .build();
                })
                .collect(Collectors.toList());
    }
    @SneakyThrows
    public void modify(OfferDto offerDto, MultipartFile image, Integer offerId){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = ((Jwt)authentication.getCredentials()).getClaim("email");
        Optional<User> optionalUser = userRepository.findByEmail(userEmail);
        Integer userId = optionalUser.get().getUser_id();

        Optional<Offer> offer = offerRepository.findById(offerId);

        offer.get().setOffer_name(offerDto.offer_name);
        offer.get().setOffer_key_words(offerDto.offer_key_words);
        offer.get().setOffer_description(offerDto.offer_description);
        offer.get().setUser_id(userId);
        offer.get().setOffer_email(offerDto.offer_email);
        offer.get().setOffer_phone(offerDto.offer_phone);
        offer.get().setOffer_benefits(offerDto.offer_benefits);
        offer.get().setOffer_context(offerDto.offer_context);
        offer.get().setOffer_utilization(offerDto.offer_utilization);
        offer.get().setOffer_status(offerDto.offer_status);
        offer.get().setOffer_colaboration(offerDto.offer_colaborations);
        offer.get().setPrivate_status(offerDto.private_status);

        Offer savedOffer = offerRepository.save(offer.get());
        if(image != null) {
            Integer offerID = savedOffer.getOffer_id();
            Optional<OffersImages> offerImages = offersImagesRepository.findByOfferId(offerId);
            offerImages.get().setOffer_id(offerID);
            offerImages.get().setData(image.getBytes());


            offersImagesRepository.save(offerImages.get());
        }
    }
    public void deleteOfferById(Integer offerId){
        Offer offer = offerRepository.findById(offerId)
                .orElseThrow(() -> new RuntimeException("No agency with id " + offerId));

        imagineService.deleteOfferById(offerId);
        offerRepository.delete(offer);
    }

    public List<ViewOfferDto> searchOffers(String name){
        if(!Objects.equals(name, "")) {
            return offerRepository.findAll()
                    .stream()
                    .filter(o -> o.getOffer_name().toLowerCase().contains(name.toLowerCase()) ||
                            o.getOffer_key_words().toLowerCase().contains(name.toLowerCase()) ||
                            userRepository.findById(o.getUser_id()).get().getEmail().contains(name.toLowerCase()))
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
                                .offer_data_publication(o.getOffer_data_publication())
                                .build();
                    })
                    .collect(Collectors.toList());
        }else{
            return getAllOffers();
        }
    }

    public List<ViewOfferDto> getNewOffers(){
        List<ViewOfferDto> newOffers = getAllOffers();

        Collections.reverse(newOffers);
        return newOffers;
    }
}
