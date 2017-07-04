package com.example.hamza.coresol.ActivitiesClasses.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toolbar;
import com.bumptech.glide.Glide;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.hamza.coresol.ActivitiesClasses.Modals.MostVisitedModal;
import com.example.hamza.coresol.ActivitiesClasses.Modals.MovieModal;
import com.example.hamza.coresol.ActivitiesClasses.Modals.TopRatedMoviesModal;
import com.example.hamza.coresol.ActivitiesClasses.adapters.MostVisitedRecylerViewAdapter;
import com.example.hamza.coresol.ActivitiesClasses.adapters.ScrollMovieRecyclerViewAdapter;
import com.example.hamza.coresol.ActivitiesClasses.adapters.TopRatedRecyclerViewAdapter;
import com.example.hamza.coresol.R;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
     SliderLayout slider;
     Toolbar toolbar;
     RecyclerView recyclerView_TopRated,recyclerView_MostVisited,recyclerView_ScrollMovie;
     TopRatedRecyclerViewAdapter adapterTopRated;
     ScrollMovieRecyclerViewAdapter adapterScrollView ;
     MostVisitedRecylerViewAdapter adapterMostVisited;


    /*.....................creation of design for fragment header slider............................*/

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,container,false);

        toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        slider = (SliderLayout)view.findViewById(R.id.slider);
        recyclerView_ScrollMovie = (RecyclerView) view.findViewById(R.id.recyclerView_ScrollMovie);
        recyclerView_TopRated = (RecyclerView)view.findViewById(R.id.recyclerView_TopRated);
        recyclerView_MostVisited = (RecyclerView)view.findViewById(R.id.recyclerView_MostVisited);
        getActivity();

        /*......................RecyclarView MovieScroll adapter and its array.................................*/

        ArrayList<MovieModal> arrayList_ScrollMovie = new ArrayList<>();

        MovieModal MM = new MovieModal(R.drawable.one);
        arrayList_ScrollMovie.add(MM);

        MM = new MovieModal(R.drawable.two);

        arrayList_ScrollMovie.add(MM);

        MM = new MovieModal(R.drawable.five);
        arrayList_ScrollMovie.add(MM);

        MM = new MovieModal(R.drawable.four);
        arrayList_ScrollMovie.add(MM);

        MM = new MovieModal(R.drawable.five);
        arrayList_ScrollMovie.add(MM);

        MM = new MovieModal(R.drawable.three);
        arrayList_ScrollMovie.add(MM);

        MM = new MovieModal(R.drawable.three);
        arrayList_ScrollMovie.add(MM);

        adapterScrollView = new ScrollMovieRecyclerViewAdapter(getActivity(),arrayList_ScrollMovie);    // horizontal ListView
        RecyclerView.LayoutManager ManagerScrollMovie = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView_ScrollMovie.setLayoutManager(ManagerScrollMovie);
        recyclerView_ScrollMovie.setItemAnimator(new DefaultItemAnimator());
        recyclerView_ScrollMovie.setAdapter(adapterScrollView);


  /*   ...............header slider.......................*/

        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Hannibal",R.drawable.one);
        file_maps.put("Big Bang Theory",R.drawable.two);
        file_maps.put("House of Cards",R.drawable.three);
        file_maps.put("Game of Thrones", R.drawable.four);
        file_maps.put("Game of Thrones", R.drawable.five);


        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getContext());
            // initialize a SliderLayout
            textSliderView
                   // .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            slider.addSlider(textSliderView);
        }
        slider.setPresetTransformer(SliderLayout.Transformer.Accordion);
     //   slider.setPresetTransformer(SliderLayout.Transformer.Fade);
     //   slider.setPresetTransformer(SliderLayout.Transformer.RotateDown);
        slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        slider.setCustomAnimation(new DescriptionAnimation());
        slider.setDuration(4000);
        slider.addOnPageChangeListener(this);
/*...................................End of slider here...............................................................*/

                        /*Just Pretty like AlexZendra Daadario*/

/*...................................RecyclerView(Top Rated Movie's) Adapter and all its grid code......................*/

        ArrayList<TopRatedMoviesModal> arrayListTopRated = new ArrayList<>();
        TopRatedMoviesModal TopRated = new TopRatedMoviesModal("Tena",R.drawable.one);
        arrayListTopRated.add(TopRated);
        TopRated = new TopRatedMoviesModal("Alex",R.drawable.one);
        arrayListTopRated.add(TopRated);
        TopRated = new TopRatedMoviesModal("Jeen",R.drawable.two);
        arrayListTopRated.add(TopRated);
        TopRated = new TopRatedMoviesModal("Rock",R.drawable.three);
        arrayListTopRated.add(TopRated);
        TopRated = new TopRatedMoviesModal("Nena",R.drawable.four);
        arrayListTopRated.add(TopRated);
        TopRated = new TopRatedMoviesModal("Tena",R.drawable.five);
        arrayListTopRated.add(TopRated);
        TopRated = new TopRatedMoviesModal("Tena",R.drawable.five);
        arrayListTopRated.add(TopRated);
        TopRated = new TopRatedMoviesModal("Tena",R.drawable.five);
        arrayListTopRated.add(TopRated);
        TopRated = new TopRatedMoviesModal("Tena",R.drawable.five);
        arrayListTopRated.add(TopRated);
        TopRated = new TopRatedMoviesModal("Tena",R.drawable.five);
        arrayListTopRated.add(TopRated);
        TopRated = new TopRatedMoviesModal("Tena",R.drawable.five);
        arrayListTopRated.add(TopRated);
        TopRated = new TopRatedMoviesModal("Tena",R.drawable.five);
        arrayListTopRated.add(TopRated);

        adapterTopRated = new TopRatedRecyclerViewAdapter(getActivity(),arrayListTopRated);
        RecyclerView.LayoutManager ManagerTopRated = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView_TopRated.setLayoutManager(ManagerTopRated);
        recyclerView_TopRated.setItemAnimator(new DefaultItemAnimator());
        recyclerView_TopRated.setAdapter(adapterTopRated);

    /*..............................End of TopRated Recyclerview...................................................*/

                                  /*haha spark expo ma dakhy dramy*/

     /*...............................MostVisited RecyclerView.....................................................*/

        ArrayList<MostVisitedModal> arrayListMostVisited = new ArrayList<>();
        MostVisitedModal MostVisted = new MostVisitedModal(R.drawable.one,"uman");
        arrayListMostVisited.add(MostVisted);
        MostVisted = new MostVisitedModal(R.drawable.one,"teena");
        arrayListMostVisited.add(MostVisted);
        MostVisted = new MostVisitedModal(R.drawable.two,"jeen");
        arrayListMostVisited.add(MostVisted);
        MostVisted = new MostVisitedModal(R.drawable.three,"alex");
        arrayListMostVisited.add(MostVisted);
        MostVisted = new MostVisitedModal(R.drawable.four,"marvan");
        arrayListMostVisited.add(MostVisted);
        MostVisted = new MostVisitedModal(R.drawable.five,"voilet");
        arrayListMostVisited.add(MostVisted);
        MostVisted = new MostVisitedModal(R.drawable.one,"ketty");
        arrayListMostVisited.add(MostVisted);
        MostVisted = new MostVisitedModal(R.drawable.two,"caly");
        arrayListMostVisited.add(MostVisted);
        MostVisted = new MostVisitedModal(R.drawable.three,"jemy");
        arrayListMostVisited.add(MostVisted);
        MostVisted = new MostVisitedModal(R.drawable.four,"alex");
        arrayListMostVisited.add(MostVisted);
        MostVisted = new MostVisitedModal(R.drawable.five,"jakob");
        arrayListMostVisited.add(MostVisted);
        MostVisted = new MostVisitedModal(R.drawable.one,"hamy");
        arrayListMostVisited.add(MostVisted);

        adapterMostVisited = new MostVisitedRecylerViewAdapter(getActivity(),arrayListMostVisited);
//        RecyclerView.LayoutManager ManagerMostVisited = new GridLayoutManager(getActivity(),4);
        RecyclerView.LayoutManager ManagerMostVisited = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView_MostVisited.setLayoutManager(ManagerMostVisited);
        recyclerView_MostVisited.setItemAnimator(new DefaultItemAnimator());
        recyclerView_MostVisited.setAdapter(adapterMostVisited);

        /*.........................haha expo ho rh hmm b mangnment kry chal usman ..................................*/

        return  view;
    }
    /*..............sliderView header method ..................*/
    @Override
    public void onSliderClick(BaseSliderView slider) {
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }
    @Override
    public void onPageSelected(int position) {
    }
    @Override
    public void onPageScrollStateChanged(int state) {

    }

    }


