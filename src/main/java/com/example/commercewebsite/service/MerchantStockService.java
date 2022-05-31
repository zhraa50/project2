package com.example.commercewebsite.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class MerchantStockService {
    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();
    public ArrayList<MerchantStock> getMerchantStock() {
        return merchantStocks;
    }


    public boolean AddMerchantStocK(MerchantStock merchantStock) {
        return merchantStocks.add(merchantStock);

    }

    public String UpdateCategory(Integer index, MerchantStock merchantStock) {

        return merchantStocks.set(index,merchantStock);


    }

    public boolean DeleteCategory(Integer index) {
        return merchantStocks.remove(index);
    }
}



