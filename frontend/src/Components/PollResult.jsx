import React from "react";
import { useState } from "react";

const PollResult = ({poll, vote}) => {
    const [vote, setVote] = useState();

    handleClick = (voteResult) => {
        setVote(voteResult);
        this.props.history.push('/pollResult')
    }

    return (
    <div className="inputDiv">
        <h2>{poll.getPollName}</h2>
        <p>Du stemte {vote}</p>
        <p>Ja stemmer: {poll.yesVotes}</p>
        <p>Nei stemmer: {poll.noVotes}</p>
    </div>
    );
}

export default PollResult;