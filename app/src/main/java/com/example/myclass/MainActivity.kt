package com.example.myclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myclass.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapterStudent = StudentAdapter(generateMahasiswa()){
                student -> Toast.makeText(this@MainActivity, "Hei! You clicked on ${student.nama}",
            Toast.LENGTH_SHORT).show()
        }
        with(binding){
            revStudent.apply {
                adapter = adapterStudent
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }



    fun generateMahasiswa(): List<Student> {
        val mahasiswaList = mutableListOf<Student>()

        // Data mahasiswa
        val gambarMahasiswa = arrayOf(
            "https://i.pinimg.com/564x/89/59/c8/8959c86f6e8c536d3257192f157c2418.jpg",
            "https://i.pinimg.com/564x/e0/d8/5c/e0d85c577aec29bcf6821a90aa2a19b8.jpg",
            "https://i.pinimg.com/564x/df/c0/8f/dfc08f38ba17b6f91f32888420ef271c.jpg",
            "https://i.pinimg.com/564x/f9/a2/1c/f9a21ceb76fe9efb21f0401a6d003166.jpg",
            "https://i.pinimg.com/564x/85/fc/d5/85fcd54cd4873897c160e7963eed661e.jpg",
            "https://i.pinimg.com/564x/bb/a9/48/bba94828ef712d4b07df20e79baf3b8f.jpg",
            "https://i.pinimg.com/564x/28/9b/c1/289bc19a899ad4789c06578aa09f08ee.jpg",
            "https://i.pinimg.com/564x/71/cf/8a/71cf8a41560d71191cf55fdbe990b94c.jpg",
            "https://i.pinimg.com/564x/15/5d/e9/155de92035b1a0b62a6751bf1ec6d411.jpg",
            "https://i.pinimg.com/564x/45/8a/1d/458a1df647dad57550f87076945658fc.jpg",
            "https://i.pinimg.com/564x/f4/94/88/f49488dce3b6f2b10b6a44a11a3eebb1.jpg",
            "https://i.pinimg.com/564x/51/9a/2b/519a2b510accd91371f5ce987f92ecb0.jpg",
            "https://i.pinimg.com/564x/67/a5/78/67a5784f036197b048c3a1ca9b1d0381.jpg",
            "https://i.pinimg.com/564x/aa/fc/9d/aafc9df8a7263ede67d194e876f48d7b.jpg",
            "https://i.pinimg.com/564x/d1/ad/3c/d1ad3c59f768131980be2b9787d4631b.jpg",
            "https://i.pinimg.com/564x/9f/67/1b/9f671be630f50fbd2e23d2ad57792ae1.jpg",
            "https://i.pinimg.com/736x/40/1e/61/401e61a5732f2535f66c95a5c3190e18.jpg",
            "https://i.pinimg.com/564x/d3/59/17/d3591791c95927c8b712450e3570968e.jpg",
            "https://i.pinimg.com/564x/e6/1e/db/e61edb17842a0b3cd1821a1627acac6a.jpg",
            "https://i.pinimg.com/564x/1a/84/35/1a8435b262f70dc441a52bf15a9c620d.jpg"
        )

        val namaMahasiswa = arrayOf(
            "Hiroshi Tanaka", "Yuki Sato", "Aoi Suzuki", "Ryo Yamamoto", "Sakura Nakamura",
            "Kaito Kobayashi", "Akari Ito", "Haruto Watanabe", "Mio Takahashi", "Yuto Kimura",
            "Miyu Sasaki", "Taichi Ito", "Rin Yamada", "Ren Suzuki", "Hina Nakajima",
            "Sora Yamaguchi", "Airi Nakano", "Takeru Kato", "Nanami Inoue", "Souta Hayashi"
        )

        val programStudi = arrayOf(
            "Teknik Informatika", "Manajemen Bisnis", "Ilmu Komunikasi", "Arsitektur", "Keperawatan",
            "Psikologi", "Ekonomi", "Hukum", "Akuntansi", "Kedokteran",
            "Sosiologi", "Farmasi", "Fisika", "Sastra Inggris", "Kimia",
            "Desain Grafis", "Teknik Sipil", "Pendidikan Matematika", "Kedokteran Gigi", "Teknik Elektro"
        )


//        Random ipk
        val random = java.util.Random()

        for (i in 0 until gambarMahasiswa.size) {
            val student = Student(
                gambar = gambarMahasiswa[i],
                nama = namaMahasiswa[i],
                programStudi = programStudi[i],
                ipk = String.format("%.1f", 1.5 + random.nextDouble() * 2.5).toDouble()

            )
            mahasiswaList.add(student)
        }

        return mahasiswaList
    }


}