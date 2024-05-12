package Graduation.thesis.ECommerce.project.Service.Impl;

import Graduation.thesis.ECommerce.project.Enity.Size;
import Graduation.thesis.ECommerce.project.Model.SizesDTO;
import Graduation.thesis.ECommerce.project.Service.SizesService;
import Graduation.thesis.ECommerce.project.dao.SizeDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Transactional
@Service
public class SizesServiceImpl implements SizesService {
    @Autowired
    SizeDao SizeDao;

    @Override
    public void insert(SizesDTO SizesDTO) {
        Size Sizes = new Size();
        Sizes.setName(SizesDTO.getName());
        SizeDao.insert(Sizes);
        SizesDTO.setId(Sizes.getId());
    }

    @Override
    public void update(SizesDTO SizesDTO) {
        Size Sizes = SizeDao.get(SizesDTO.getId());
        if (Sizes != null) {
            Sizes.setName(SizesDTO.getName());
            Sizes.setId(SizesDTO.getId());
            SizeDao.update(Sizes);
        }
    }

    @Override
    public void delete(Long id) {
        Size Sizes = SizeDao.get(id);
        if (Sizes != null) {
            SizeDao.delete(Sizes);
        }

    }

    @Override
    public SizesDTO get(Long id) {

        Size Sizes = SizeDao.get(id);
        SizesDTO SizesDTO = new SizesDTO();
        SizesDTO.setId(Sizes.getId());
        SizesDTO.setName(Sizes.getName());
        return SizesDTO;
    }

    @Override
    public List<SizesDTO> search(String name, int start, int length) {
        List<Size> categories = SizeDao.search(name, start, length);
        List<SizesDTO> SizesDTOs = new ArrayList<SizesDTO>();
        for (Size Sizes : categories) {
            SizesDTO SizesDTO = new SizesDTO();
            SizesDTO.setId(Sizes.getId());
            SizesDTO.setName(Sizes.getName());
            SizesDTOs.add(SizesDTO);
        }
        return SizesDTOs;
    }


}
