package physics.com.physics;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import physics.com.physics.adapters.ViewPagerAdapter;
import physics.com.physics.fragments.OneFragment;
import physics.com.physics.fragments.ReflectionMaterialFragment;
import physics.com.physics.fragments.ReflectionTestFragment;
import physics.com.physics.fragments.ReflectionVideosFragment;
import physics.com.physics.fragments.TwoFragment;

/**
 * Created by bruno on 31/10/15.
 */
public class ReflectionActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_tab);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ReflectionMaterialFragment(), getResources().getString(R.string.tab_material));
        adapter.addFragment(new ReflectionVideosFragment(), getResources().getString(R.string.tab_videos));
        adapter.addFragment(new ReflectionTestFragment(), getResources().getString(R.string.tab_tests));
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

}
