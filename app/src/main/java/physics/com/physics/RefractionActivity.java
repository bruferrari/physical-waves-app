package physics.com.physics;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;

import physics.com.physics.adapters.ViewPagerAdapter;
import physics.com.physics.fragments.OneFragment;
import physics.com.physics.fragments.RefractionMaterialFragment;
import physics.com.physics.fragments.RefractionQuestionsFragment;
import physics.com.physics.fragments.RefractionVideosFragment;

/**
 * Created by bruno on 30/10/15.
 */
@SuppressWarnings("deprecation")
public class RefractionActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_layout);

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
        adapter.addFragment(new RefractionMaterialFragment(), getResources().getString(R.string.tab_material));
        adapter.addFragment(new RefractionVideosFragment(), getResources().getString(R.string.tab_videos));
        adapter.addFragment(new RefractionQuestionsFragment(), getResources().getString(R.string.tab_tests));
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
