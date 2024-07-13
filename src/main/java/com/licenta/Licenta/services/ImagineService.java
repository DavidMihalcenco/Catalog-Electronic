package com.licenta.Licenta.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.licenta.Licenta.dtos.ViewInfrastructureDto;
import com.licenta.Licenta.entities.Infrastructure;
import com.licenta.Licenta.entities.InfrastructuresImages;
import com.licenta.Licenta.entities.OffersImages;
import com.licenta.Licenta.repositories.InfrastructureRepository;
import com.licenta.Licenta.repositories.InfrastructuresImagesRepository;
import com.licenta.Licenta.repositories.OffersImagesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImagineService {
    private final InfrastructuresImagesRepository infrastructuresImagesRepository;
    private final OffersImagesRepository offersImagesRepository;
    public void deleteInfrastructureById(Integer infrastructureId) {
        InfrastructuresImages infrastructuresImages = infrastructuresImagesRepository.findByInfrastructureId(infrastructureId)
                .orElseThrow(() -> new RuntimeException("No agency with id " + infrastructureId));

        infrastructuresImagesRepository.delete(infrastructuresImages);
    }

    public void deleteOfferById(Integer offerId) {
        OffersImages offersImages = offersImagesRepository.findByOfferId(offerId)
                .orElseThrow(() -> new RuntimeException("No agency with id " + offerId));

        offersImagesRepository.delete(offersImages);
    }
}
