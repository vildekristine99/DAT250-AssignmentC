import React from "react";
import { useState } from "react";

const PublishPoll = ({pollName, vote}) => {
    const [vote, setVote] = useState();

    handleClick = (voteResult) => {
        setVote(voteResult);
        this.props.history.push('/pollResult')
    }

    return (
    <div className="inputDiv">
        <h2>{pollName}</h2>
        <button className="whiteButton" onClick={() => handleClick ("yes")}>Yes</button>
        <button className="whiteButton" onClick={() => handleClick ("no")}>No</button>
    </div>
    );
}

export default PublishPoll;