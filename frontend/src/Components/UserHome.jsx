import React from "react";
import AuthService from "../Service/auth.service.js";
import { useEffect, useState } from "react";
import { withRouter } from "react-router-dom";
import { useHistory } from "react-router-dom";

const UserHome = ({ props }) => {
  const [pollArray, setPollArray] = useState([]);
  const history = useHistory();

  useEffect(() => {
    setPollArray(AuthService.getCurrentUser().polls);
    console.log(pollArray);
  }, []);

  const handleClick = () => {
    history.push("/userPolls");
    window.location.reload();
  };

  return (
    <div className="inputDiv">
      <button className="whiteButton">Create Polls</button>
      <button className="whiteButton" onClick={handleClick}>
        My Polls
      </button>

      <input className="pinInput" type="text" placeholder="Enter pin..." />
    </div>
  );
};

export default UserHome;
