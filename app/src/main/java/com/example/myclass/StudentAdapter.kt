package com.example.myclass

import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.myclass.databinding.ItemStudentBinding
import com.squareup.picasso.Picasso
import eightbitlab.com.blurview.BlurView

typealias  onClickStudent = (Student) -> Unit

class StudentAdapter(private val listStudent: List<Student>,
                        private val onClickStudent: onClickStudent) :
    RecyclerView.Adapter<StudentAdapter.ItemStudentViewHolder>() {

    inner class ItemStudentViewHolder(private val binding: ItemStudentBinding) :
        RecyclerView.ViewHolder(binding.root){

        fun bind(data : Student){
            with(binding){
                namaMahasiswaTxt.text = data.nama
                programStudiTxt.text = data.programStudi
                ipkTxt.text = data.ipk.toString()

                // Atur warna teks IPK berdasarkan kriteria
                val context = itemView.context
                when {
                    data.ipk < 2.0 -> ipkTxt.setTextColor(ContextCompat.getColor(context, R.color.red))
                    data.ipk < 3.0 -> ipkTxt.setTextColor(ContextCompat.getColor(context, R.color.yellow))
                    data.ipk < 4.0 -> ipkTxt.setTextColor(ContextCompat.getColor(context, R.color.green))
                    else -> ipkTxt.setTextColor(ContextCompat.getColor(context, R.color.blue))
                }

                // Muat gambar mahasiswa dari URL menggunakan Picasso
                Picasso.get().load(data.gambar).into(imgMahasiswa)

//                Ketika item diklik
                itemView.setOnClickListener{
                    val dialog = Dialog(itemView.context)
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                    dialog.setContentView(R.layout.detail_student)


                    val imgDetailMahasiswa = dialog.findViewById<ImageView>(R.id.detailImgMahasiswa)
                    val namaDetailTxt = dialog.findViewById<TextView>(R.id.detailNamaMahasiswaTxt)
                    val programStudiDetailTxt = dialog.findViewById<TextView>(R.id.detailProgramStudiTxt)
                    val ipkDetailTxt = dialog.findViewById<TextView>(R.id.ipk_txt)


                    val data = listStudent[adapterPosition]
                    Picasso.get().load(data.gambar).into(imgDetailMahasiswa)
                    namaDetailTxt.text = namaMahasiswaTxt.text
                    programStudiDetailTxt.text = programStudiTxt.text
                    ipkDetailTxt.text = ipkTxt.text
                    ipkDetailTxt.setTextColor(ipkTxt.currentTextColor)



                    dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                    dialog.show()
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemStudentViewHolder {
        val binding = ItemStudentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)

        return  ItemStudentViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listStudent.size
    }

    override fun onBindViewHolder(holder: ItemStudentViewHolder, position: Int) {
        holder.bind(listStudent[position])
    }
}