import { useState, useEffect } from "react";

function App() {
  const [students, setStudents] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetch("http://localhost:3000/students")
      .then((response) => {
        if (!response.ok) throw new Error("Network Response is not ok");
        console.log(response);

        return response.json;
      })
      .then((data) => {
        setStudents(data);
        setLoading(false);
      })
      .catch((err) => {
        setError(err);
        setLoading(false);
      });
  }, []);

  if (loading) return <p>Loading Request...</p>;
  if (error) return <p>Error: {error}</p>;

  return (
    <div style={{ padding: "2px", margin: "2px" }}>
      <h2>List of Students</h2>
      <ul>
        {students.map((student) => (
          <li key={student.id}>{student.name}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;
