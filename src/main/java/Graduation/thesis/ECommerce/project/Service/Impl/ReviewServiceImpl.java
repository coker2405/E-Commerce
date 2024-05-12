package Graduation.thesis.ECommerce.project.Service.Impl;

import Graduation.thesis.ECommerce.project.Enity.Product;
import Graduation.thesis.ECommerce.project.Enity.Review;
import Graduation.thesis.ECommerce.project.Enity.User;
import Graduation.thesis.ECommerce.project.Model.ProductDTO;
import Graduation.thesis.ECommerce.project.Model.ReviewDTO;
import Graduation.thesis.ECommerce.project.Model.SearchReviewDTO;
import Graduation.thesis.ECommerce.project.Model.UserDTO;
import Graduation.thesis.ECommerce.project.Service.ReviewService;
import Graduation.thesis.ECommerce.project.Utils.DateTimeUtils;
import Graduation.thesis.ECommerce.project.dao.ReviewDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Transactional
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewDao reviewDao;

    @Override
    public void add(ReviewDTO reviewDTO) {
        Review review = new Review();
        review.setReviewDate(new Date());
        review.setStarNumBer(reviewDTO.getStarNumber());
        review.setProduct(new Product(reviewDTO.getProductDTO().getId()));
        User user= new User();
        user.setName(reviewDTO.getUserDTO().getName());
        user.setId(reviewDTO.getUserDTO().getId());
        review.setUser(user);
        reviewDao.add(review);

    }

    @Override
    public void delete(Long id) {
        Review review = reviewDao.getById(id);
        if (review != null) {
            reviewDao.delete(review);
        }

    }

    @Override
    public void edit(ReviewDTO reviewDTO) {
        Review review = reviewDao.getById(reviewDTO.getId());
        if (review != null) {
            review.setStarNumBer(reviewDTO.getStarNumber());
            review.setProduct(new Product(reviewDTO.getProductDTO().getId()));
            User user= new User();
            user.setName(reviewDTO.getUserDTO().getName());
            review.setUser(user);
        }
        reviewDao.edit(review);
    }

    @Override
    public ReviewDTO getById(Long id) {
        Review review = reviewDao.getById(id);
        if (review != null) {
            convert(review);
        }
        return null;
    }

    private ReviewDTO convert(Review review) {
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setId(review.getId());
        reviewDTO.setReviewDate(DateTimeUtils.formatDate(review.getReviewDate(), DateTimeUtils.DD_MM_YYYY_HH_MM));
        reviewDTO.setStarNumber(review.getStarNumBer());
        ProductDTO productDTO= new ProductDTO();
        productDTO.setId(review.getProduct().getId());
        reviewDTO.setProductDTO(productDTO);
        UserDTO userDTO= new UserDTO();
        userDTO.setName(review.getUser().getName());
        reviewDTO.setUserDTO(userDTO);
        return reviewDTO;
    }

    @Override
    public List<ReviewDTO> find(Long productId) {
        List<Review> reviews = reviewDao.find(productId);
        List<ReviewDTO> reviewDTOs = new ArrayList<ReviewDTO>();
        reviews.forEach(rev -> {
            reviewDTOs.add(convert(rev));
        });
        return reviewDTOs;
    }

    @Override
    public Long count(SearchReviewDTO searchReviewDTO) {

        return reviewDao.count(searchReviewDTO);
    }

    @Override
    public Long countTotal(SearchReviewDTO searchReviewDTO) {

        return reviewDao.count(searchReviewDTO);
    }

}
