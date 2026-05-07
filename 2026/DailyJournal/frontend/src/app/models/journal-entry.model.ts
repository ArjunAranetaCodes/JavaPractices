export interface JournalEntry {
  id?: number;
  title: string;
  content?: string;
  entryDate: string;
  mood?: string;  // HAPPY | NEUTRAL | SAD
}
