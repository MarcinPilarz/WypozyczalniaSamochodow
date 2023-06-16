import React, { useEffect, useState } from 'react';
import '../App.css';
import '../UserPanel.css';
import NavBar from './NavBar';
import Footer from './Footer';

function UserPanel() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [klient, setKlient] = useState(null);
  const [error, setError] = useState(null);
  const [editMode, setEditMode] = useState(false);
  const [updatedEmail, setUpdatedEmail] = useState('');
  const [updatedPhoneNumber, setUpdatedPhoneNumber] = useState('');

  useEffect(() => {
    const userLoggedIn = localStorage.getItem('isLoggedIn') === 'true';
    setIsLoggedIn(userLoggedIn);

    const idKlienta = localStorage.getItem('idKlienta');
    const fetchKlient = async () => {
      try {
        const response = await fetch(`http://localhost:8080/kliencit/${idKlienta}`);
        if (response.ok) {
          const data = await response.json();
          setKlient(data);
        } else {
          throw new Error('Request failed');
        }
      } catch (error) {
        setError(error.message);
      }
    };

    fetchKlient();
  }, []);

  const handleEditClick = () => {
    setUpdatedEmail(klient.email);
    setUpdatedPhoneNumber(klient.nrTelefonu_klient);
    setEditMode(true);
  };

  const handleSaveClick = async () => {
    try {
      const response = await fetch(`http://localhost:8080/klienci/${klient.idKlienta}`, {
          method: 'PUT',
          headers: {
              'Content-Type': 'application/json',
          },
          body: JSON.stringify({
              email: updatedEmail,
              nrTelefonu_klient: updatedPhoneNumber,
          }),
      });

      if (response.ok) {
        // Pomyślnie zaktualizowano dane
        setKlient({
          ...klient,
          email: updatedEmail,
          nrTelefonu_klient: updatedPhoneNumber,
        });
        setEditMode(false);
      } else {
        throw new Error('Request failed');
      }
    } catch (error) {
      setError(error.message);
    }
  };


  return (
    <>
      <NavBar isLoggedIn={isLoggedIn} />
      <section className="user-panel-section">
        <div>

        <p className="logo2">
        Car<span>Rent</span>
        </p>
          {error ? (
            <p>Wystąpił błąd: {error}</p>
          ) : (
            klient && (
              <div>
                <h3 className="user-panel-title">
                  {klient.imie_klient} {klient.nazwisko_klient}
                </h3>
                <p className="user-panel-email">
                  Email: {editMode ? (
                    <input type="text" value={updatedEmail} onChange={(e) => setUpdatedEmail(e.target.value)} className="user-panel-input square" />
                  ) : (
                    klient.email
                  )}
                </p>
                <p className="user-panel-phone">
                  Numer telefonu: {editMode ? (
                    <input type="text" value={updatedPhoneNumber} onChange={(e) => setUpdatedPhoneNumber(e.target.value)} className="user-panel-input" />
                  ) : (
                    klient.nrTelefonu_klient
                  )}
                </p>

                {editMode ? (
                  <button className="user-panel-save-button " onClick={handleSaveClick}>Zapisz</button>
                ) : (
                  <button className="user-panel-edit-button"onClick={handleEditClick} >Edytuj</button>
                )}

                
              </div>
            )
          )}
        </div>
      </section>
      <Footer className="footer" />
    </>
  );
}

export default UserPanel;
