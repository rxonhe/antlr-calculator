import React from 'react';
import '../css/ResultFrame.css';

const ResultFrame = ({ result }) => {
    return (
        <div>
            <h2>Result:</h2>
            <div>{result !== null ? result : 'No result yet'}</div>
        </div>
    );
};

export default ResultFrame;
