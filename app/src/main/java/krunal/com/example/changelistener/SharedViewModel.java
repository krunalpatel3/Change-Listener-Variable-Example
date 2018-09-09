package krunal.com.example.changelistener;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;


public class SharedViewModel extends ViewModel {

    private final MutableLiveData<String> current_date = new MutableLiveData<String>();

    public void init(){
        current_date.setValue("No Date Selected");
    }

    public void setDate(String date) {
        Log.i("setDate",date);
        current_date.setValue(date);
    }

    public LiveData<String> getDate() {
        return current_date;
    }
}
