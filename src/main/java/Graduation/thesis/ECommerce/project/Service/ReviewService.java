package Graduation.thesis.ECommerce.project.Service;

import Graduation.thesis.ECommerce.project.Model.ReviewDTO;
import Graduation.thesis.ECommerce.project.Model.SearchReviewDTO;

import java.util.*;

public interface ReviewService {

    void add(ReviewDTO reviewDTO);

    void delete(Long id);

    void edit(ReviewDTO reviewDTO);

    ReviewDTO getById(Long id);

    List<ReviewDTO> find(Long id);

    Long count(SearchReviewDTO searchReviewDTO);

    Long countTotal(SearchReviewDTO searchReviewDTO);
}
