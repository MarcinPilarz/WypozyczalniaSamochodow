import React from "react";
import { Link } from "react-router-dom";

const NoPage = () => {
  return (
    <div style={{ display: "flex", flexDirection: "column", alignItems: "center", justifyContent: "center", height: "100vh" }}>
      <h1 style={{ fontSize: "6rem", marginBottom: "3rem" }}>Page not found err:404</h1>
      <Link to="/">
        <button style={{ fontSize: "3rem", padding: "1rem 3rem", borderRadius: "1rem", backgroundColor: "#007bff", color: "#fff", border: "none" }}>Zabierz mnie na stronę główną</button>
      </Link>
    </div>
  );
};

export default NoPage;
