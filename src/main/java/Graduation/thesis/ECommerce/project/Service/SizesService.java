package Graduation.thesis.ECommerce.project.Service;

import Graduation.thesis.ECommerce.project.Model.SizesDTO;


import java.util.*;

public interface SizesService {

    void insert(SizesDTO sizesDTO);

    void update(SizesDTO sizesDTO);

    void delete(Long id);

    List<SizesDTO> search(String name, int start, int length);

    SizesDTO get(Long id);
}
