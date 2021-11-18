import React from "react";
import AuthService from "../Service/auth.service.js";

const UserHome = () => {
  const getJSONObject = () => {
    console.log(AuthService.getCurrentUser());
  };

  return (
    <div className="inputDiv">
      <button className="whiteButton" onClick={getJSONObject()}>
        Create Polls
      </button>
      <button className="whiteButton">My Polls</button>
      <input className="pinInput" type="text" placeholder="Enter pin..." />
    </div>
  );
};

export default UserHome;