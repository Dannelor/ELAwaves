package cse.uta.elawaves.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.elastos.carrier.FriendInfo;

import androidx.navigation.Navigation;
import cse.uta.elawaves.R;

public class AddFriendFragment extends Fragment{

    OnAddFriendFragmentListener callback;

    public interface OnAddFriendFragmentListener {
        void onAddFriend(FriendInfo info);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_friend,container,false);

        IntentIntegrator intentIntegrator = IntentIntegrator.forSupportFragment(this);
            intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
            intentIntegrator.setPrompt("Scan Friends Address");
            intentIntegrator.setOrientationLocked(true);
            intentIntegrator.initiateScan();

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result != null){
            // Implement Friend adding logic here;
        }
        Navigation.findNavController(getView()).navigate(R.id.action_addFriendFragment_to_friendsFragment);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        if(context instanceof OnAddFriendFragmentListener)
            callback = (OnAddFriendFragmentListener) context;
        else
            throw new ClassCastException(context.toString() + " must implement OnAddFriendFragmentListener");
    }

    @Override
    public void onDetach(){
        callback = null;
        super.onDetach();
    }

}
