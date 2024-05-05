package Graduation.thesis.ECommerce.project.dao;

import Graduation.thesis.ECommerce.project.Enity.Review;
import Graduation.thesis.ECommerce.project.Model.SearchReviewDTO;

import java.util.*;

public interface ReviewDao {

    void add(Review review);

    void delete(Review review);

    void edit(Review review);

    Review getById(Long id);

    List<Review> find(Long productId);

    Long count(SearchReviewDTO searchReviewDTO);

    Long countTotal(SearchReviewDTO searchReviewDTO);
}