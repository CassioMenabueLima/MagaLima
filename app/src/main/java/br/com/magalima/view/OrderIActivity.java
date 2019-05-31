package br.com.magalima.view;


public interface OrderIActivity {


    interface OrderViewImpl {
        String KEY = "order";

        public void showToast(String mensagem);
        public void showProgressBar(int visibilidade);
        public void updateListaRecycler();
            public String getIdUser();

    }

}
