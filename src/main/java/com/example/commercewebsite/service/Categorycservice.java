package com.example.commercewebsite.service;

import com.example.commercewebsite.model.Category;
import com.example.commercewebsite.model.Merchant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class Categorycservice {
    ArrayList<Category> categorye = new ArrayList<>();


    public ArrayList<Category> getCategory() {
        return categorye;
    }

    public boolean AddCategory(Category category) {
        return categorye.add(category);

    }

    public String  UpdateCategory(int index, Category category)
        {
            categorye.set(index,category);
            return "category is UPDATE ";
        }

      public String DeleteCategory(Integer index){
          categorye.remove(index);
          return "category is delet  ";

      }

    @Service
    public static class MerchantSerivce {

        ArrayList<Merchant> merchants = new ArrayList<>();

        public ArrayList<Merchant> getMerchant() {
            return merchants;
        }

        public boolean AddMerchant(Merchant merchant) {

            return merchants.add(merchant);

        }

        public String UpdateMerchant(int index, Merchant merchant) {
            return merchants.set(index, merchant);

        }

        public Merchant deleteMerchant(int index) {
            return merchants.remove(index);

        }


    }
}