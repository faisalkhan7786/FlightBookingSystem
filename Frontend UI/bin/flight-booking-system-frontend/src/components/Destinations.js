import React from 'react'
import image1 from '../assets/image1.jpeg'
import image2 from '../assets/image2.jpg'
import image3 from '../assets/image3.jpg'

const Destinations = () => {
  return (
    <section className='destinations'>
      <h3>Join us for the world's first fully vaccinated flight!!! </h3>
      <div className='grid'>
        <div>
          <img src={image1} alt='destination-1' />
          <h3>Fly to UAE</h3>
          <p>
            In the last three years, Dubai saw an increase in 4 and 5 star hotels and number of rooms, but a decrease in standard hotel apartments.
            Prior to the Expo 2020 hotels in Dubai were reducing room rates to stimulate demand as supply accelerated.
          </p>
        </div>

        <div>
          <img src={image2} alt='destination-2' />
          <h3>Italy Experience</h3>
          <p>
            With 94 million tourists per year (2018) according to ENIT, Italy is the third most visited country in international tourism arrivals,
            with 217.7 million foreign visitors nights spent and a total of 432.6 million visitors.
          </p>
        </div>

        <div>
          <img src={image3} alt='destination-3' />
          <h3>Switzerland Special</h3>
          <p>
            Tourists are drawn to Switzerland's diverse landscape as well as activities.
            One of the most interesting tourist places are the Alpine climate and landscapes, in particular for skiing and mountaineering.
          </p>
        </div>
      </div>
    </section>
  )
}

export default Destinations
