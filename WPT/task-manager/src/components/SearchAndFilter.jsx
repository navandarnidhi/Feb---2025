import { Form, Stack } from 'react-bootstrap'

function SearchAndFilter({ searchTerm, onSearchChange, filterPriority, onFilterChange }) {
  return (
    <Stack direction="horizontal" gap={3} className="mb-4">
      <Form.Control
        type="text"
        placeholder="Search tasks..."
        value={searchTerm}
        onChange={(e) => onSearchChange(e.target.value)}
      />
      <Form.Select
        style={{ width: '200px' }}
        value={filterPriority}
        onChange={(e) => onFilterChange(e.target.value)}
      >
        <option value="all">All Priorities</option>
        <option value="low">Low</option>
        <option value="medium">Medium</option>
        <option value="high">High</option>
      </Form.Select>
    </Stack>
  )
}

export default SearchAndFilter