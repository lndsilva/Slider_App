package br.senac.sp.slider_app;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by laercio.nsilva on 26/02/2018.
 */

public class Slide_Adapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    //lista de imagens

    public int[] lst_imagens = {
            R.drawable.astronauta,
            R.drawable.buraco_negro,
            R.drawable.foguete,
            R.drawable.satelite

    };

    //lista de titulos

    public String[] lst_titulo = {
            "ASTRONALTA",
            "SATELITE",
            "GALAXIA",
            "FOGUETE"
    };
    //lista de descrições

    public String[] lst_descricao = {
            "Descrição 1",
            "Descrição 2",
            "Descrição 3",
            "Descrição 4"
    };

    public int[] lst_backgroundcolor = {
            Color.rgb(55, 55, 55),
            Color.rgb(239, 85, 85),
            Color.rgb(110, 49, 89),
            Color.rgb(1, 188, 212),
    };

    public Slide_Adapter(Context context){
        this.context = context;

    }

    @Override
    public int getCount() {
        return lst_titulo.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide, container, false);
        LinearLayout layoutslide =  (LinearLayout) view.findViewById(R.id.slidelinearlayout);
        ImageView imgslide = (ImageView) view.findViewById(R.id.slideimg);
        TextView txtTitle = (TextView) view.findViewById(R.id.txtTitulo);
        TextView descrition = (TextView) view.findViewById(R.id.txtDescricao);
        layoutslide.setBackgroundColor(lst_backgroundcolor[position]);
        imgslide.setImageResource(lst_imagens[position]);
        txtTitle.setText(lst_titulo[position]);
        descrition.setText(lst_descricao[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
