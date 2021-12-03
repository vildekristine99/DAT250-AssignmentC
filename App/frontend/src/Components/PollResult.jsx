import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import { useLocation } from "react-router";

const PollResult = () => {
  const location = useLocation();
  const [poll, setPoll] = useState([]);

  useEffect(() => {
    setPoll(location.state);
    console.log(poll);
  }, [location]);

  return (
    <div className="inputDiv">
      <div className="viewpoll">
        <p>{poll.pollName}</p>
        <div className="btns-wrapper">
          <button className="btns">Yes votes: {poll.yesVotes}</button>
          <button className="btns">No votes: {poll.noVotes}</button>
        </div>
      </div>
      <a href="/#/userPolls" className="loginReg">
        Go back
      </a>
    </div>
  );
};

export default PollResult;
