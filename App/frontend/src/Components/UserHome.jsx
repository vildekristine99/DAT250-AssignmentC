import React from "react";
import AuthService from "../Service/auth.service.js";
import { useEffect, useState } from "react";
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
    console.log(pollArray);
    window.location.reload();
  };

  const handleClick2 = () => {
    history.push("/publishPoll");
    console.log(pollArray);
    window.location.reload();
  };

  return (
    <div className="inputDiv">
      <button className="whiteButton" onClick={handleClick2}>Create Polls</button>
      <button className="whiteButton" onClick={handleClick}>
        My Polls
      </button>

      <input className="pinInput" type="text" placeholder="Enter pin..." />
    </div>
  );
};

export default UserHome;
