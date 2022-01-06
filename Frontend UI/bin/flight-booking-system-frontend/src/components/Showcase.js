import React from 'react'
import bgImage from '../assets/video.mp4'

const Showcase = () => {
  return (
    <section className='showcase'>
      <div className='showcase-overlay'>
        <video autoPlay loop muted>
          <source src={bgImage} type="video/mp4"></source>
           </video>
            <h1>Welcome to Air <i>transat</i></h1>
            <p>
             <h4>Live today. Tomorrow will cost more. The world's favourite airline.</h4>
            </p>
          </div>
        </section>
        )
}

        export default Showcase
