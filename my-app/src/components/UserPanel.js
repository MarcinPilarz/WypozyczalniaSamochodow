

import React, { useEffect, useState } from 'react';
import '../App.css';
import NavBar from './NavBar';
import Footer from './Footer';

function UserPanel() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  useEffect(() => {
    const userLoggedIn = localStorage.getItem('isLoggedIn') === 'true';
    setIsLoggedIn(userLoggedIn);
  }, []);

  return (
    <>
      <NavBar isLoggedIn={isLoggedIn} />
      <section>
        <div>{/* Twój kod dla UserPanel */}</div>
      </section>
      <Footer />
    </>
  );
}


export default UserPanel;