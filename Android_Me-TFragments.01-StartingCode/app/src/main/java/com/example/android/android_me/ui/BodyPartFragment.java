    package com.example.android.android_me.ui;

    import android.os.Bundle;
    import android.support.v4.app.Fragment;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ImageView;

    import com.example.android.android_me.R;

    import java.util.List;


    public class BodyPartFragment extends Fragment {
        private int displayIndex;
        private List<Integer> imageids;
        private ImageView andoidPic;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
            andoidPic = rootView.findViewById(R.id.pictureAndroid);

            refresh();

            return rootView;


        }

        public void refresh() {
            if (imageids != null)
                andoidPic.setImageDrawable(getResources().getDrawable(imageids.get(displayIndex)));

        }

        public int getDisplayIndex() {
            return displayIndex;
        }

        public void setDisplayIndex(int displayIndex) {
            this.displayIndex = displayIndex;
        }

        public void setImageids(List<Integer> imageids) {
            this.imageids = imageids;
        }
    }