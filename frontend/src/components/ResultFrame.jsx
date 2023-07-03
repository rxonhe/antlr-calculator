import React from 'react';
import '../css/ResultFrame.css';
import '../css/Util.css';

const ResultFrame = ({ result }) => {
    return (
        <div className={"result-container"}>
            <h2 className={"result-text"}>Result:</h2>
            <div >{result !== null ? result : 'No result yet'}</div>
        </div>
    );
};

export default ResultFrame;
