package com.example.sop.ui.createSop;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sop.R;
import com.example.sop.api.Const;

import java.io.FileNotFoundException;
import java.io.InputStream;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_create_sop#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_create_sop extends Fragment {

    private ImageView imageView;
    private final int Pick_image = 1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_create_sop() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_create_sop.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_create_sop newInstance(String param1, String param2) {
        fragment_create_sop fragment = new fragment_create_sop();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_create_sop, container, false);

        ImageView imageView = root.findViewById(R.id.sopImage_imageView);

        Button button = null;
        button = root.findViewById(R.id.select_photo_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, Pick_image);
            }
        });


        String[] factories = {"Завод 1", "Завод 2", "Завод 3", "Завод 4", "Участок 957"};
        ArrayAdapter<String> factory_adapter = new ArrayAdapter<String>(this.getContext(),android.R.layout.select_dialog_singlechoice, factories);
        AutoCompleteTextView facTextView = (AutoCompleteTextView) root.findViewById(R.id.factory_ACTextView);
        facTextView.setAdapter(factory_adapter);

        String[] departments = {"Цех 1", "Цех 2", "Цех 3", "Участок 4", "Участок 5"};
        ArrayAdapter<String> department_adapter = new ArrayAdapter<String>(this.getContext(),android.R.layout.select_dialog_singlechoice, departments);
        AutoCompleteTextView dacTextView = (AutoCompleteTextView) root.findViewById(R.id.department_ACTextView);
        dacTextView.setAdapter(department_adapter);

        String[] sectors = {"Участок 1", "Участок 2", "Участок 3", "Участок 4"};
        ArrayAdapter<String> sector_adapter = new ArrayAdapter<String>(this.getContext(),android.R.layout.select_dialog_singlechoice, sectors);
        AutoCompleteTextView sacTextView = (AutoCompleteTextView) root.findViewById(R.id.sector_ACTextView);
        sacTextView.setAdapter(sector_adapter);

        String[] categories = {"Категорія 1", "Категорія 2", "Категорія 3", "Категорія 4", "Категорія 5"};
        ArrayAdapter<String> category_adapter = new ArrayAdapter<String>(this.getContext(),android.R.layout.select_dialog_singlechoice, categories);
        AutoCompleteTextView cacTextView = (AutoCompleteTextView) root.findViewById(R.id.category_ACTextView);
        cacTextView.setAdapter(category_adapter);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button createSop = view.findViewById(R.id.createSop_button);
        createSop.setOnClickListener(view1 -> Navigation.findNavController(view1)
                .navigate(R.id.action_nav_create_sop_to_fragment_create_sop_steps));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        imageView = (ImageView) getActivity().findViewById(R.id.sopImage_imageView);

        switch(requestCode) {
            case Pick_image:
                if(resultCode == RESULT_OK){
                    try {
                        final Uri imageUri = imageReturnedIntent.getData();
                        final InputStream imageStream = getActivity().getApplicationContext().getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        imageView.setImageBitmap(selectedImage);
                    } catch (FileNotFoundException e) {
                        Log.i(Const.TAG, e.getMessage());
                    }
                }
                else{
                    Log.i(Const.TAG, "Молодец блять!");
                }
        }
    }
}