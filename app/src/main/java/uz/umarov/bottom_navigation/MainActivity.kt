package uz.umarov.bottom_navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import uz.umarov.bottom_navigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadFragment(FavFragment())
        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.favourites -> {
                    loadFragment(FavFragment())
                    true
                }
                R.id.recent -> {
                    loadFragment(RecentFragment())
                    true
                }
                R.id.Contacts -> {
                    loadFragment(ContactFragment())
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout,fragment)
        transaction.commit()
    }


}