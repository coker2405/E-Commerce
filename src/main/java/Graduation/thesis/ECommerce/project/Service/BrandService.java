package Graduation.thesis.ECommerce.project.Service;

import Graduation.thesis.ECommerce.project.Model.BrandDTO;

import java.util.*;

public interface BrandService {
      void add(BrandDTO brandDTO);
      void update(BrandDTO brandDTO);
      void delete(long id);
      BrandDTO get(long id);
      List<BrandDTO> search(String name, int start, int length);

}
