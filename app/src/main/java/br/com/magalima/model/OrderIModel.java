package br.com.magalima.model;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

import br.com.magalima.domain.Moto;


public interface OrderIModel {
    interface CarModelImpl{
        public void retrieveMotos();
        public void updateEhFavoritoMoto(Moto moto);
    }


}
