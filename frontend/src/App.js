import React, {useEffect, useState} from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Container, Row, Col, Button } from 'reactstrap';
import './App.css';
import Header from './Header';
import Footer from './Footer';
import { defaultProfileImgUrl, timestampToDate, serverUrl } from './Config';

const baseRequestConfig = {
    headers: {
        "Accept": 'application/json',
        "Content-Type": "application/json"
    },
    redirect: "follow"
};

function App() {
    const [texts, setTexts] = useState([]);

    useEffect(() => {

        fetch(serverUrl + "api/home", {
            method: 'GET',
            ...baseRequestConfig
        })
            .then(response => response.json())
            .then(data => setTexts(data))
            .catch(error => console.error(error));

    }, []);

    return (
        <div>
            <Header />

            <Container className="mt-4">
                {texts.map(text => (
                    <div className="text-center text-body mb-4 mt-1" key={text.id}>
                        <a href={'user/' + text.user.username}>
                            <div className="text-on-image-container">
                                <img src={text.user.profileImgUrl || defaultProfileImgUrl} alt="Profile" />
                                <div className="text-on-image-centered">{text.user.username}</div>
                            </div>
                        </a>
                        <Row className='mt-1'>
                            <Col>
                                <p className='mb-3 mt-3'>{text.content}</p>
                                <Row className='text-center'>
                                    <Col className='downvote'>
                                        <Button color='danger' className='fw-bold'>
                                            -{text.downvotes.length}
                                        </Button>
                                    </Col>
                                    <Col className='text-muted fw-bold mt-3'>{timestampToDate(text.timestamp)}</Col>
                                    <Col className='upvote fw-bold'>
                                        <Button color='success' className='fw-bold'>
                                            +{text.upvotes.length}
                                        </Button>
                                    </Col>
                                </Row>
                            </Col>
                        </Row>
                    </div>
                ))}
            </Container>

            <Footer />
        </div>
    );
}

export default App;
