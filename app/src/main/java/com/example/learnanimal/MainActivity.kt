package com.example.learnanimal

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.view.*

class MainActivity : AppCompatActivity() {

    var listOfAnimals = ArrayList<Animal>()
    var adapter: AnimalsAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // add the animals to array list
        listOfAnimals.add(Animal("Bear","Bears are dangerous animals. They eat fishes mostly",R.drawable.bear,true))
        listOfAnimals.add(Animal("Bird","Birds can fly. Their sound is very relaxing and beautiful. There are so many variants of birds.",R.drawable.bird,false))
        listOfAnimals.add(Animal("Camel","Mostly seen in the Arab peninsula. They have hump.",R.drawable.camel,false))
        listOfAnimals.add(Animal("Cat","Cats are very cute. But also they don't care anything. They live how they want :D",R.drawable.cat,false))
        listOfAnimals.add(Animal("Chicken","Chickens have wing but they can't fly. They spawn eggs.",R.drawable.chicken,false))
        listOfAnimals.add(Animal("Dog","Dogs are very friendly to humans. They protect you outer dangers.",R.drawable.dog,false))
        listOfAnimals.add(Animal("Lion","Lions are the king of the jungle. They eat meat and they are the symbol of power.",R.drawable.lion,true))
        listOfAnimals.add(Animal("Rabbit","Rabbit eats carrot and it runs very fast! Most favorite rabbit is Bugs Bunny :)",R.drawable.rabbit,false))
        listOfAnimals.add(Animal("Sheep","Sheep is very cute. You can drink its milk. And they are mostly curly.",R.drawable.sheep,false))
        listOfAnimals.add(Animal("Snake","Snake is a reptile. Some snakes are poisonous. Be careful!",R.drawable.snake,true))

        adapter = AnimalsAdapter(this,listOfAnimals)
        listview_main.adapter = adapter
    }

    class AnimalsAdapter: BaseAdapter{

        var listOfAnimals = ArrayList<Animal>()
        var context:Context?=null
        constructor(context: Context, listOfAnimals: ArrayList<Animal>):super(){
            this.listOfAnimals = listOfAnimals
            this.context = context
        }


        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val animal = listOfAnimals[position]
            if(animal.isDangerous == true){
                var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflater.inflate(R.layout.animal_dangerous_ticket,null)
                myView.textViewName.text = animal.name!!
                myView.textViewDescription.text = animal.description!!
                myView.image_animal.setImageResource(animal.image!!)
                return myView
            }else{
                var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflater.inflate(R.layout.animal_ticket,null)
                myView.textViewName.text = animal.name!!
                myView.textViewDescription.text = animal.description!!
                myView.image_animal.setImageResource(animal.image!!)
                return myView
            }


        }

        override fun getItem(position: Int): Any {
            return position
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listOfAnimals.size
        }

    }
}
