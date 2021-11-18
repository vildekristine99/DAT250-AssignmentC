import React from "react";
import { useState } from "react";
import { useEffect } from "react";
import { useLocation } from "react-router";
import PollService from "../Service/PollService.js";
/*
const ViewPoll = ({ poll, vote }) => {
  const [vote, setVote] = useState();

  handleClick = (voteResult) => {
    setVote(voteResult);
    this.props.history.push("/pollResult");
  };

  return (
    <div className="inputDiv">
      <h2>{poll.getPollName}</h2>
      <p>Du stemte {vote}</p>
      <p>Ja stemmer: {poll.yesVotes}</p>
      <p>Nei stemmer: {poll.noVotes}</p>
    </div>
  );
};

export default ViewPoll;
*/

const ViewPoll = () => {
  //const location = useLocation();
  const [poll, setPoll] = useState([]);

  useEffect(() => {
    //setPoll(location.state);
    setPoll(PollService.getCurrentPoll());
    console.log(poll);
  }, []);

  return (
    <div className="inputDiv">
      <h2>{poll.pollName}</h2>
    </div>
  );
};

export default ViewPoll;
