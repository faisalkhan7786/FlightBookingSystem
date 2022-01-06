import React from 'react'
import { NavLink } from 'react-router-dom'
import Logo from '../Logo/air.png'

const Header = () => {
  return (
    <header className='header'>
      <div>
        <NavLink exact activeClassName='active' className='links' to='/'>
        <img src={Logo} alt='Flight Logo' />
        </NavLink>
      </div>

      <nav className='navbar'>
        <ul>
          <NavLink exact activeClassName='active' className='links' to='/login'>
            Admin
          </NavLink>

          <NavLink exact activeClassName='active' className='links' to='/search'>
            Search
          </NavLink>

          <NavLink exact activeClassName='active' className='links' to='/checkin'>
            Checkin
          </NavLink>

         
          
        </ul>
      </nav>
    </header>
  )
}

export default Header
