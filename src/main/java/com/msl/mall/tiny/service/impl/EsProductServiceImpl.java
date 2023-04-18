package com.msl.mall.tiny.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.msl.mall.tiny.dao.EsProductDao;
import com.msl.mall.tiny.nosql.elasticsearch.document.EsProduct;
import com.msl.mall.tiny.nosql.elasticsearch.repository.EsProductRepository;
import com.msl.mall.tiny.service.EsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class EsProductServiceImpl implements EsProductService {

    @Autowired
    private EsProductDao esProductDao;
    @Autowired
    private EsProductRepository esProductRepository;
    @Override
    public int importAll() {
        List<EsProduct> allEsProductList = esProductDao.getAllEsProductList(null);
        int result=0;
        if(allEsProductList!=null){
            Iterable<EsProduct> esProducts = esProductRepository.saveAll(allEsProductList);
            Iterator<EsProduct> iterator = esProducts.iterator();

            while(iterator.hasNext()){
                result++;
                iterator.next();
            }

        }
        return result;
    }

    @Override
    public void delete(Long id) {
        esProductRepository.deleteById(id);

    }

    @Override
    public EsProduct create(Long id) {
        List<EsProduct> allEsProductList = esProductDao.getAllEsProductList(id);
        EsProduct result=null;
        if(allEsProductList.size()>0){
            EsProduct esProduct = allEsProductList.get(0);
            result = esProductRepository.save(esProduct);
        }
        return result;
    }

    @Override
    public void delete(List<Long> ids) {
        if(!CollectionUtil.isEmpty(ids)){
            List<EsProduct> esProductList = new ArrayList<>();
            for(Long id:ids){
                EsProduct esProduct = new EsProduct();
                esProduct.setId(id);
                esProductList.add(esProduct);
            }
            esProductRepository.deleteAll(esProductList);
        }


    }

    @Override
    public Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize) {

        return esProductRepository.findByNameOrSubTitleOrKeywords(keyword,keyword,keyword, PageRequest.of(pageNum,pageSize));
    }
}
