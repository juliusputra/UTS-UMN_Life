package com.example.umn_life

class Timing {
    var Currtime: Int = 0;
    var TickTime: Int = 0;

    //while running ticktime++
    //Ambil 1 jam = 15s

    if(TickTime <= 0)
    {
        if(TickTime >= 15)
        {
            Currtime++;
            TickTime = 0;
            if(Currtime >= 24)
            {
                Currtime = 1;
            }
            return;
        }
        TickTime++;
    }

    if(Currtime <= 11)
    {
        TimeOfDay.Morning.Greetings
        //insert picture pagi
    }
    else if(Currtime >= 12 && Currtime <= 14)
    {
        TimeOfDay.Afternoon.Greetings
        //insert picture siang
    }
    else if(CurrTime >= 15 && Currtime <= 18)
    {
        TimeOfDay.Evening.Greetings
        //insert picture sore
    }
    else if (CurrTime >= 19 && Currtime <= 24)
    {
        TimeOfDay.Night.Greetings
        //insert picture malem
    }
}

enum class TimeOfDay(val Greetings: String)
{
    Morning("Selamat Pagi"),
    Afternoon("Selamat Siang"),
    Evening("Selamat Sore"),
    Night("Selamat Setelah Sore");
}