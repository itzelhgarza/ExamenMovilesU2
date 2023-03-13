package mx.edu.itson.examenu2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class Regalos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regalos)

        var adapter: DetalleAdapter? = null



    }
    class DetalleAdapter: BaseAdapter{
        var context: Context? = null
        var detalles = ArrayList<Detalles>()

        constructor(context: Context, detalles: ArrayList<Detalles>){
            this.context = context
            this.detalles = peliculas
        }
        override fun getCount(): Int {
            return detalles.size
        }

        override fun getItem(p0: Int): Any {
            return detalles[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }
        override fun getView(position: Int, coverView: View?, parent: ViewGroup?): View {
            var detalles = detalles[position]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflator.inflate(R.layout.activity_detalle_regalos, null)

            var image: ImageView = vista.findViewById(R.id.iv_regalo_imagen)
            var titulo: TextView = vista.findViewById(R.id.tv_regalo_nombre)
            var precio: TextView = vista.findViewById(R.id.tv_regalo_precio)


            image.setImageResource(detalles.image)
            titulo.setText(detalles.titulo)
            precio.setText(detalles.precio)

            image.setOnClickListener{
                //var seatsAvailable = 20 - pelicula.seats.size
                //Log.d("SEATS", "$seatsAvailable")
                var intento = Intent(context, ::class.java)

                intento.putExtra("titulo", pelicula.titulo)
                intento.putExtra("sinopsis", pelicula.sinopsis)
                intento.putExtra("header", pelicula.header)
                intento.putExtra("imagen", pelicula.image)
                intento.putExtra("numberSeats",(20-pelicula.seats.size))
                intento.putExtra("pos", position)
                context!!.startActivity(intento)
            }
            return vista
        }


    }


    }
}