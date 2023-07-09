import React from 'react';
import {List, Typography} from 'antd';

const ResultDisplay = ({results}) => {
    return (
        <List
            header={<div>Results</div>}
            bordered
            dataSource={results}
            renderItem={(item) => (
                <List.Item>
                    <Typography.Text>{item}</Typography.Text>
                </List.Item>
            )}
        />
    );
};

export default ResultDisplay;