package Project3.com.welcome_home.services;

import Project3.com.welcome_home.entities.Delivered;
import Project3.com.welcome_home.entities.DeliveredId;
import Project3.com.welcome_home.repositories.DeliveredRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeliveredService {

    private final DeliveredRepository deliveredRepository;

    public DeliveredService(DeliveredRepository deliveredRepository) {
        this.deliveredRepository = deliveredRepository;
    }

    public Optional<Delivered> getDelivered(DeliveredId deliveredId) {
        return deliveredRepository.findById(deliveredId);
    }

    public Delivered saveDelivered(Delivered delivered) {
        return deliveredRepository.save(delivered);
    }
}
