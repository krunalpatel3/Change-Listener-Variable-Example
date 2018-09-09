package krunal.com.example.changelistener;

import android.arch.lifecycle.ViewModelProviders;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    private SectionsPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;

    private SharedViewModel mSharedviewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        // set the title in toolbar.
        toolbar.setTitle(getTitle());
        // set color of the text or title in toolbar.
        toolbar.setTitleTextColor(0xFFFFFFFF);
        setSupportActionBar(toolbar);

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.viewPager);
        setupViewPager(mViewPager);

        mSharedviewModel = ViewModelProviders.of(this).get(SharedViewModel.class);
        mSharedviewModel.init();

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentOne(), getResources().getString(R.string.fragmentOne));
        adapter.addFragment(new FragmentTwo(),getResources().getString(R.string.fragmentTwo));
        viewPager.setAdapter(adapter);
    }


}
