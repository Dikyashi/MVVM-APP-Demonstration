package com.dikku.mvvm_app_demonstration;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dikku.mvvm_app_demonstration.model.VolumeResponse;
import com.dikku.mvvm_app_demonstration.view.BookAdapter;
import com.dikku.mvvm_app_demonstration.viewmodel.BookViewModel;
import com.google.android.material.textfield.TextInputEditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BookFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookFragment extends Fragment {

   BookViewModel mBookViewModel;
   BookAdapter  mBookAdapter;

    private TextInputEditText keywordEditText, authorEditText;
    private Button searchButton;


    public BookFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static BookFragment newInstance() {
        BookFragment fragment = new BookFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBookAdapter = new BookAdapter();
        mBookViewModel = new ViewModelProvider(this).get(BookViewModel.class);
        mBookViewModel.init();
        mBookViewModel.getVolumeResponseLiveData().observe(this, volumeResponse -> {
                if (volumeResponse != null) {
                    mBookAdapter.setVolumeResponses(volumeResponse.getItems());
                }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_book, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.fragment_booksearch_searchResultsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(mBookAdapter);

        keywordEditText = view.findViewById(R.id.fragment_booksearch_keyword);
        authorEditText = view.findViewById(R.id.fragment_booksearch_author);
        searchButton = view.findViewById(R.id.fragment_booksearch_search);

        searchButton.setOnClickListener(v -> performSearch());

        return view;
    }

    private void performSearch() {
        String keyword = keywordEditText.getEditableText().toString();
        String author = authorEditText.getEditableText().toString();

        mBookViewModel.searchVolumes(keyword, author);
    }
}