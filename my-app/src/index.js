import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import axios from 'axios';
import { useState, useEffect } from 'react';
import CarDetailsSection from './components/CarDetailsSection';
import Home from './Home';


function MyComponent() {
  const [data, setData] = useState([]);

 

  useEffect(() => {
    axios.create({basseURL: 'http://localhost:8080'}).get('/cars').then(response => {
      console.log(response.data);
    });
  }, []);

   let tableRows = data.map(item => (
    <tr key={item.id}>
      <td>{item.id}</td>
      <td>{item.name}</td>
      <td>{item.description}</td>
    </tr>
  ));
  return (
    <div>
      {data.map(item => (
        <p key={item.id}>{item.name}</p>
      ))}

      <div>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
          </tr>
        </thead>
        <tbody>
          {tableRows}
        </tbody>
      </table>
    </div>
  
    </div>
  );
}
axios.create({baseURL: 'http://localhost:8080'}).get('/cars').then(response => {
 console.log(response.data);
});

console.log("test");
 const root = ReactDOM.createRoot(document.getElementById('root'));
 root.render(
   <React.StrictMode>
     
     <App />
     
   </React.StrictMode>
 );

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
