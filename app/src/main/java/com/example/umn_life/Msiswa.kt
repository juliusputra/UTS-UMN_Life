package com.example.umn_life

class Msiswa(var Nem:String, var Fud: Int = 10,var Tiredness: Int = 0, var Gaming: Int = 0, var Study: Int = -2 ) {
    var fullfood: Boolean = false;
    var wellrest: Boolean = false;
    var epicgamer: Boolean = false;
    var bookworm: Boolean = false;
    fun Naming(Name: String)
    {
        Nem = Name;
    }

    fun Consoomfood(Food: Int)
    {
        Foodcheck(Fud);
        if(fullfood == true)
        {
            Fud += Food;
        }

    }
    fun Regen(SleepTime: Int)
    {
        Slepcheck(Tiredness);
        if(wellrest == true) {
            Tiredness += SleepTime;
        }
    }
    fun Smurfing(GameTime: Int)
    {
        Gamecheck(Gaming);
        if(epicgamer == true) {
            // insert warning "too much gaming"
            Gaming += GameTime;

        }
    }
    fun Nerd(NerdTime: Int)
    {
//        StudCheck(Study); <- di akhir check if Study <= x, if true then lulus else gagal
        Study += NerdTime;
    }

    fun Foodcheck(Food: Int)
    {
        fullfood = false;
        if(Food >= 11)
        {
            Fud = 10;
            fullfood = true;
        }
    }
    fun Slepcheck(SleepTime: Int)
    {
        wellrest = false;
        if(SleepTime <= 0)
        {
            Tiredness = 0;
            wellrest = true;
        }
    }
    fun Gamecheck(GameTime: Int)
    {
        epicgamer = false;
        if(GameTime >= 10)
        {
            epicgamer = true;
        }
    }
    fun StudCheck(NerdTime: Int)
    {
        bookworm = false;
        if(NerdTime >= 11)
        {
            Study = 10;
            bookworm = true;
        }

    }
}